import React, { Component } from 'react';
import '../css/Board.css';
import Note from './Note';

class Board extends Component {
    constructor() {
        super();
        this.state = {
            notes: [
                // {
                //     title: "Class Notes",
                //     body: "Always use constructors when extending another class",
                // },
                // {
                //     title: "Bloop",
                //     body: "blop",
                // },
                // {
                //     title: "Third title",
                //     body: "Third body",
                // },
            ]
        }
    }

    addNote() {
        let notes = this.state.notes;
        notes.push(
            {
                id: Date.now()
            }
        );
        this.setState({notes});

    }

    deleteNote(id) {
        let newNoteArr = this.state.notes;
        newNoteArr.map((note, index) => {
            if (id === note.id) {
                newNoteArr.splice(index,1); 
            }
        });
        this.setState({notes: newNoteArr});
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
                         deleteHandler={this.deleteNote.bind(this)} />)
                        }
          
                    </div>
                </div>
                <div>
                    <button onClick={this.addNote.bind(this)} className="btn btn-success add-button">
                        Add
                    </button>
                </div>
            </div>
        )
    }
}

export default Board;