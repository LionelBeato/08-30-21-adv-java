import { Injectable } from '@angular/core';
import { InMemoryDbService } from 'angular-in-memory-web-api';
import { Student } from './student';

@Injectable({
  providedIn: 'root',
})
export class InMemoryDataService implements InMemoryDbService {
  createDb() {
    const students = [
      { id: 1, name: 'Bob', major: 'Computer Science' },
      { id: 2, name: 'Sheila', major: 'History' },
      { id: 3, name: 'Taylor', major: 'English' },
      { id: 4, name: 'James', major: 'Statistics' },
      { id: 5, name: 'Claire', major: 'Chemistry' },
      { id: 6, name: 'John', major: 'Political Science' },
      { id: 7, name: 'Emily', major: 'Business' },
      { id: 8, name: 'David', major: 'Mechanical Engineering' },
      { id: 9, name: 'Jessica', major: 'Economics' },
      { id: 10, name: 'Steve', major: 'Graphic Design' },
    ];
    return { students };
  }

  genId(students: Student[]): number {
    return students.length > 0 ? Math.max(...students.map(student => student.id)) + 1 : 11;
  }

  constructor() {}
}
