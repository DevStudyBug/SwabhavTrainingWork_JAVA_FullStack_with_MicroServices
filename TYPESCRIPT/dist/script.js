"use strict";
Object.defineProperty(exports, "__esModule", { value: true });
// basic data type 
// any , unknown , never , void , enums , number , string , boolen
let arr = [1, "a", 2, true];
console.log(arr);
let variable;
variable = 12;
variable = "string";
let value;
value = 12;
value = "12";
function num() {
    return "12";
}
num().charAt(1);
function c() {
    //cant return anything
}
// never
function runInfinite() {
    while (true) {
        console.log("infinite run");
    }
}
runInfinite();
console.log("hii"); // function after never run bcz above fun it run infinite
//Enum
var MousePosition;
(function (MousePosition) {
    MousePosition[MousePosition["x"] = 0] = "x";
    MousePosition[MousePosition["y"] = 0] = "y";
})(MousePosition || (MousePosition = {}));
MousePosition.y;
var Direction;
(function (Direction) {
    Direction["top"] = "TOP";
    Direction["left"] = "LEFT";
    Direction["right"] = "RIGHT";
    Direction["bottom"] = "BOTTOM";
})(Direction || (Direction = {}));
Direction.bottom;
var Human;
(function (Human) {
    Human["name"] = "harsh";
    Human[Human["age"] = 25] = "age";
})(Human || (Human = {}));
console.log(Human.name); // prints "harsh"
//# sourceMappingURL=script.js.map