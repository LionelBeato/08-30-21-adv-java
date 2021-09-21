import { Injectable } from '@angular/core';
import { Student } from './student';
import { STUDENTS } from './mock-students';
import { Observable, of } from 'rxjs';
import { MessageService } from './message.service';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { catchError, map, tap } from 'rxjs/operators';

@Injectable({
  providedIn: 'root',
})
export class StudentService {
  private studentsUrl = 'api/students';

  /* 
    this is a getter for our students
    that we are importing from our "database" file
  */
  getStudents(): Observable<Student[]> {
    // this.messageService.add('StudentService: fetched students');
    return this.http.get<Student[]>(this.studentsUrl)
    .pipe(
      tap(_ => this.log('fetched students')),
      catchError(this.handleError<Student[]>('getStudents', []))
    )
  }

  getStudent(id: number): Observable<Student> {
    const url =`${this.studentsUrl}/${id}`;
    return this.http.get<Student>(url).pipe(
      tap(_=> this.log(`fetched hero id=${id}`)),
      catchError(this.handleError<Student>(`getStudent id=${id}`))
    )
  }

  private handleError<T>(operation = 'operation', result?: T) {
    return (error: any): Observable<T> => {
      console.error(error); 
      this.log(`${operation} failed: ${error.message}`)
      return of(result as T); 
    }
  }

  private log(message: string) {
    this.messageService.add(`StudentService: ${message}`);
  }

  constructor(
    private http: HttpClient,
    private messageService: MessageService
  ) {}
}
