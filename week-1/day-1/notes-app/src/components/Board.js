import React, { Component } from 'react';
import '../css/Board.css';
import Note from './Note';
import myFirebase from '../utility/myFirebase';
import { onValue, set, push, child, remove } from "firebase/database";

const GENERIC_NOTE_TITLE = "New Note Title";
const GENERIC_NOTE_BODY = "New Note Body";

class Board extends Component {
    constructor() {
        super();
        this.state = {
            notes: []
        }
        this.firebaseDBref = myFirebase.getFireBaseRef();
        // this.firebaseDBref.once('value').then((snapshot) => console.log(snapshot.val()));
        onValue(this.firebaseDBref, (snapshot) => this.addNote(snapshot.val()), {
            onlyOnce: true,
        })

    }

    addNote(notes) {
        console.log(notes);
        if (notes) {
            for (let key in notes) {
                console.log(notes[key].title)
                this.state.notes.push(
                    {
                        id: key,
                        title: notes[key].title,
                        body: notes[key].body,
                    }
                )
            };
        } else {
            let pushRef = push(this.firebaseDBref);
            set(pushRef, {
                title: GENERIC_NOTE_TITLE,
                body: GENERIC_NOTE_BODY
            });
            this.state.notes.push(
                {
                    id: pushRef.key,
                    title: GENERIC_NOTE_TITLE,
                    body: GENERIC_NOTE_BODY,
                }
            );
        };
        this.setState(
            { notes: this.state.notes }
        );

    }

    deleteNote(id) {
        let newNoteArr = this.state.notes;
        newNoteArr.map((note, index) => {
            if (id === note.id) {
                newNoteArr.splice(index, 1);
                remove(child(this.firebaseDBref, id));
            }
        });
        this.setState({ notes: newNoteArr });
    }

    render() {
        return (
            <div>
                <div className="div-board">
                    <div className="row">

                        {
                            this.state.notes.map(note =>
                                <Note key={note.id}
                                    id={note.id}
                                    title={note.title}
                                    body={note.body}
                                    firebaseDBref={this.firebaseDBref}
                                    deleteHandler={this.deleteNote.bind(this)} />)
                        }

                    </div>
                </div>
                <div>
                    <button onClick={this.addNote.bind(this, null)} className="btn btn-success add-button">
                        Add
                    </button>
                </div>
            </div>
        )
    }
}

export default Board;