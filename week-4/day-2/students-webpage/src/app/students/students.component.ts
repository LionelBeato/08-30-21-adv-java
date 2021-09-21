import { Component, OnInit } from '@angular/core';
import { Student } from '../student';
import { StudentService } from '../student.service';
import { MessageService } from '../message.service';

@Component({
  selector: 'app-students',
  templateUrl: './students.component.html',
  styleUrls: ['./students.component.css'],
})
export class StudentsComponent implements OnInit {
  // student: Student = {
  //   id: 1,
  //   name: 'Jim',
  //   major: 'Computer Science',
  // };

  students?: Student[];
  selectedStudent?: Student;

  getStudents(): void {
    // this.students = this.studentService.getStudents();
    this.studentService
      .getStudents()
      .subscribe((students) => (this.students = students));
  }

  constructor(
    private studentService: StudentService,
    private messageService: MessageService
  ) {}

  ngOnInit(): void {
    this.getStudents();
  }

  onSelect(student: Student): void {
    this.selectedStudent = student;
    this.messageService.add(`StudentComponent: Selected student id=${student.id} `)
  }
}
