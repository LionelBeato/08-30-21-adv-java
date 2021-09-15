/*
    This is a typescript file
    it while compile down to .js utilizing
    the typescript compiler at the command line
    the command is "tsc file-name.ts"
*/
var helloWorld = "Hello World";
/*
    This is how we typically set up a js object
*/
var user = {
    name: "Hayes",
    id: 0
};
/*
    Below is how one would set up an object of a
    specified type. We use the "colon: TypeName" syntax.
*/
var otherUser = {
    name: "David",
    id: 1
};
// boolean
var isCompleted = false;
// numbers
var decimal = 4;
var hex = 0xf00d;
var binary = 10;
var octal = 484;
// let big: bigint = 100n;
// string
var color = "blue";
var colorTwo = "red";
var colorThree = "green";
// arrays
/*
    These arrays are declared differently
    but are the exact same data type.
    Note how the second one mimics the declaration
    for an arrayList in Java utilizing generics.
*/
var numArray = [1, 2, 3];
var list = [1, 2, 3];
// tuples
var x = ["hello", 10];
// below will throw an error because we are not following
// the order of the types for our tuple
// x = [10, "hello"];
var Color;
(function (Color) {
    Color[Color["Red"] = 0] = "Red";
    Color[Color["Green"] = 1] = "Green";
    Color[Color["Blue"] = 2] = "Blue";
})(Color || (Color = {}));
var c = Color.Green;
// unknown
/*
    Here we are utilizing the unknown type.
    This allows us to reassign the variable to any type
    and is useful when dealing with unknown types of data
    such as from an API.
*/
var notSure = 4;
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
function warnUser() {
    console.log("This is a warning!!!!");
}
// null and undefined
var u = undefined;
var n = null;
// type assertions
/*
    Similar to casting in Java, you can assert the types
    of specific variables. Here we know someValue is a string
    despite the fact that typescript believes its simply "unknown"
*/
var someValue = "this is a string";
var strLength = someValue.length;
var otherLength = someValue.length;
function printLabel(labeledObj) {
    console.log(labeledObj.label);
}
var myObj = { size: 10, label: "Size 10 Object" };
printLabel(myObj);
function createSquare(config) {
    var newSquare = { color: "white", area: 100 };
    if (config.color) {
        newSquare.color = config.color;
    }
    if (config.width) {
        newSquare.area = config.width * config.width;
    }
    return newSquare;
}
var mySquare = createSquare({ color: "black" });
console.log("this is the value of mySquare:", mySquare);
var p1 = { x: 10, y: 20 };
// below is illegal because we declared the prop as readonly
// thus we are unable to reassign it
// p1.x = 5;
var readonlyArray = [1, 2, 3, 4, 5];
// here we have a variable of type SearchFunc that is equal
// to an anonymous function (arrow function) that satisfies the interface
var mySearch = function (source, subString) {
    var result = source.search(subString);
    return result > -1;
};
// since the parameters are technically known, we can simplify declaring them
var otherSearch = function (src, sub) {
    var result = src.search(sub);
    return result > -1;
};
var Clock = /** @class */ (function () {
    function Clock(h, m) {
        this.currentTime = new Date();
    }
    Clock.prototype.setTime = function (d) {
        this.currentTime = d;
    };
    return Clock;
}());
var square = {};
square.color = "blue";
square.sideLength = 10;
// functions
// here is how we would declare functions in js
function add(x, y) {
    return x + y;
}
var myAdd = function (x, y) {
    return x + y;
};
// be mindful that you can add types to your functions
function addTwo(x, y) {
    return x + y;
}
var myAddTwo = function (x, y) {
    return x + y;
};
function buildName(firstName, lastName) {
    return firstName + " " + lastName;
}
// since we defined only two paramters we can only pass in two arguments
// any more or less will throw an error
var result1 = buildName("Bob", "Adams");
function optBuildName(firstName, lastName) {
    if (lastName)
        return firstName + " " + lastName;
    else
        return firstName;
}
var result2 = optBuildName("Bob");
console.log("Only Bob's first name should be returned:", result2);
function defaultBuildName(firstName, lastName) {
    if (lastName === void 0) { lastName = "Smith"; }
    return firstName + " " + lastName;
}
// be aware that the first parameter can be a default value
// but when passing in arguments, you'll need to use undefined to
// utilize the default value
// function defaultBuildName(firstName = "Bob", lastName: string) {
//   return firstName + " " + lastName;
// }
// let result3 = defaultBuildName(undefined, "Bob");
var result3 = defaultBuildName("Bob");
console.log("Bob will have the last name 'Smith' by default:", result3);
function restBuildName(firstName) {
    var restOfName = [];
    for (var _i = 1; _i < arguments.length; _i++) {
        restOfName[_i - 1] = arguments[_i];
    }
    return firstName + " " + restOfName.join(" ");
}
var restName = restBuildName("john", "jacon", "jingleheimer", "schmidt");
console.log("here is a name build with many arguments:", restName);
// union and intersection types
function padLeft(value, padding) {
    if (typeof padding === "number") {
        return Array(padding + 1).join(" ") + value;
    }
    if (typeof padding === "string") {
        return padding + value;
    }
    throw new Error("Expected string or number, got " + typeof padding + ".");
}
var padResult = padLeft("Hello world", 4);
console.log("Result of padding function:", padResult);
var myStudentWorker = {
    name: "Bobby",
    age: 24,
    employeeId: "CID32342"
};
console.log("Value of the object with an intersection type:", myStudentWorker);
