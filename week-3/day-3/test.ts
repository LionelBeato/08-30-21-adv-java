/*
    This is a typescript file
    it while compile down to .js utilizing
    the typescript compiler at the command line
    the command is "tsc file-name.ts"
*/
let helloWorld = "Hello World";

/*
    This is how we typically set up a js object
*/
const user = {
  name: "Hayes",
  id: 0,
};

/*
    Below is an interface.
    It is somewhat similar to an abstract class in Java.
    Think of it as a contract that you as a developer need
    to fulfill. 
*/
interface User {
  name: string;
  id: number;
}

/*
    Below is how one would set up an object of a
    specified type. We use the "colon: TypeName" syntax.
*/
const otherUser: User = {
  name: "David",
  id: 1,
};

// boolean
let isCompleted: boolean = false;

// numbers
let decimal: number = 4;
let hex: number = 0xf00d;
let binary: number = 0b1010;
let octal: number = 0o744;
// let big: bigint = 100n;

// string
let color: string = `blue`;
let colorTwo: string = "red";
let colorThree: string = "green";

// arrays
/*
    These arrays are declared differently
    but are the exact same data type.
    Note how the second one mimics the declaration
    for an arrayList in Java utilizing generics. 
*/
let numArray: number[] = [1, 2, 3];
let list: Array<number> = [1, 2, 3];

// tuples
let x: [string, number] = ["hello", 10];
// below will throw an error because we are not following
// the order of the types for our tuple
// x = [10, "hello"];

enum Color {
  Red, // the enum members start at 0 but you can assign it a value like so: Red = 1
  Green, // we can manually set the value for each member so Green = 4
  Blue,
}

let c: Color = Color.Green;

// unknown
/*
    Here we are utilizing the unknown type.
    This allows us to reassign the variable to any type
    and is useful when dealing with unknown types of data
    such as from an API. 
*/
let notSure: unknown = 4;
notSure = "maybe this is a string???";
notSure = false;

// any
/*
    Using the any type is a complete opt-out 
    from the type checking system given to you
    by typescript
*/
// declare function getValue(key: string): any;
// const str: string = getValue("myString");

/*
    Note that you can access undefined and nonexistent
    properties with the any type, similar to the default
    behavior of js
*/
// let looselyTyped: any = 4;
// looselyTyped.ifItExists();

// void
/*
    Like in Java, void means the absence of a type
    you use this type to define functions that don't
    return a meaningful value
*/
function warnUser(): void {
  console.log("This is a warning!!!!");
}

// null and undefined
let u: undefined = undefined;
let n: null = null;

// type assertions
/*
    Similar to casting in Java, you can assert the types
    of specific variables. Here we know someValue is a string
    despite the fact that typescript believes its simply "unknown"
*/
let someValue: unknown = "this is a string";
let strLength: number = (someValue as string).length;
let otherLength: number = (<string>someValue).length;

/*
    Note that you can use intefaces as the type
    for function parameters, encouraging clean, modular, 
    and readable code
*/
interface LabeledValue {
  label: string;
}

function printLabel(labeledObj: LabeledValue) {
  console.log(labeledObj.label);
}

let myObj = { size: 10, label: "Size 10 Object" };

printLabel(myObj);

// using a question mark allows an interface field to be optional
/*
    optional parameters are great for dynamic logic that may need
    flexible constraint
*/
interface SquareConfig {
  color?: string;
  width?: number;
}

function createSquare(config: SquareConfig): { color: string; area: number } {
  let newSquare = { color: "white", area: 100 };
  if (config.color) {
    newSquare.color = config.color;
  }
  if (config.width) {
    newSquare.area = config.width * config.width;
  }
  return newSquare;
}

let mySquare = createSquare({ color: "black" });
console.log("this is the value of mySquare:", mySquare);

/*
    readonly props
*/

interface Point {
  readonly x: number;
  readonly y: number;
}

let p1: Point = { x: 10, y: 20 };
// below is illegal because we declared the prop as readonly
// thus we are unable to reassign it
// p1.x = 5;

let readonlyArray: ReadonlyArray<number> = [1, 2, 3, 4, 5];
// below is illegal because we declared the array as readonly!
// readonlyArray[0] = 10;

// note that you can use interfaces to setup functions as well
interface SearchFunc {
  (source: string, subString: string): boolean;
}

// here we have a variable of type SearchFunc that is equal
// to an anonymous function (arrow function) that satisfies the interface
let mySearch: SearchFunc = (source: string, subString: string) => {
  let result = source.search(subString);
  return result > -1;
};

// since the parameters are technically known, we can simplify declaring them
let otherSearch: SearchFunc = (src, sub) => {
  let result = src.search(sub);
  return result > -1;
};

// classes

interface ClockInteface {
  currentTime: Date;
  setTime(d: Date): void;
}

class Clock implements ClockInteface {
  currentTime: Date = new Date();

  setTime(d: Date) {
    this.currentTime = d;
  }

  constructor(h: number, m: number) {}
}

// below we are extending interfaces
// this is similar to how inheritance operates in Java

interface Shape {
  color: string;
}

interface PenStroke {
  penWidth: number;
}

// you can extends as many interfaces as you want
interface Square extends Shape, PenStroke {
  sideLength: number;
}

let square = {} as Square;

square.color = "blue";
square.sideLength = 10;

// functions

// here is how we would declare functions in js

function add(x, y) {
  return x + y;
}

let myAdd = function (x, y) {
  return x + y;
};

// be mindful that you can add types to your functions

function addTwo(x: number, y: number): number {
  return x + y;
}

let myAddTwo = function (x: number, y: number): number {
  return x + y;
};

function buildName(firstName: string, lastName: string) {
  return firstName + " " + lastName;
}

// since we defined only two paramters we can only pass in two arguments
// any more or less will throw an error
let result1 = buildName("Bob", "Adams");

function optBuildName(firstName: string, lastName?: string) {
  if (lastName) return firstName + " " + lastName;
  else return firstName;
}

let result2 = optBuildName("Bob");
console.log("Only Bob's first name should be returned:", result2);

function defaultBuildName(firstName: string, lastName = "Smith") {
  return firstName + " " + lastName;
}

// be aware that the first parameter can be a default value
// but when passing in arguments, you'll need to use undefined to
// utilize the default value
// function defaultBuildName(firstName = "Bob", lastName: string) {
//   return firstName + " " + lastName;
// }
// let result3 = defaultBuildName(undefined, "Bob");

let result3 = defaultBuildName("Bob");
console.log("Bob will have the last name 'Smith' by default:", result3);

function restBuildName(firstName: string, ...restOfName: string[]) {
  return firstName + " " + restOfName.join(" ");
}

let restName = restBuildName("john", "jacon", "jingleheimer", "schmidt");
console.log("here is a name build with many arguments:", restName);

// union and intersection types

function padLeft(value: string, padding: string | number) {
  if (typeof padding === "number") {
    return Array(padding + 1).join(" ") + value;
  }

  if (typeof padding === "string") {
    return padding + value;
  }

  throw new Error(`Expected string or number, got ${typeof padding}.`);
}

const padResult = padLeft("Hello world", 4);
console.log("Result of padding function:", padResult);

// interface Bird {
//   fly(): void;
//   layEggs(): void;
// }

// interface Fish {
//   swim(): void;
//   layEggs(): void;
// }

// declare function getSmallPet(): Fish | Bird;

// let pet = getSmallPet();
// pet.layEggs();
// since the methods below are not shared we cannot invoke them
// pet.swim();
// pet.fly();

interface Student {
  name: string;
  age: number;
}

interface Employee {
  employeeId: string;
}

type StudentWorker = Student & Employee;

let myStudentWorker: StudentWorker = {
  name: "Bobby",
  age: 24,
  employeeId: "CID32342",
};

console.log("Value of the object with an intersection type:", myStudentWorker);
