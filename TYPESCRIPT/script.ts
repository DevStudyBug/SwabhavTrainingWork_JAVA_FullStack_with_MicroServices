// basic data type 
// any , unknown , never , void , enums , number , string , boolen
let arr : [number, string, number, boolean]=[1,"a",2, true];
console.log(arr);
let variable :any;
variable = 12;
variable = "string";
let value: unknown;
value = 12;
value = "12";

function num (): string{
    return "12";

} 
num().charAt(1);

function c (): void{
   //cant return anything

}



// never
function runInfinite(): never{  // it wil never return anything ever
    while(true){
        console.log("infinite run");
    }
}
runInfinite();
console.log("hii");  // function after never run bcz above fun it run infinite

//Enum

enum MousePosition {
  x = 0,
  y = 0,
}
MousePosition.y;


enum Direction {
  top = "TOP",
  left = "LEFT",
  right = "RIGHT",
  bottom = "BOTTOM",
}
Direction.bottom;
enum Human {
  name = "harsh",
  age = 25,
}
console.log(Human.name); // prints "harsh"