/*let variable: string | number;
variable = "12";

if (typeof variable === 'string') {;
  variable.toUpperCase();
} else if (typeof variable === 'number') {;
  variable.toFixed(2);
};*/

function abcd(variable: number | string) {
  if (typeof variable === 'number') {
    variable.toFixed(2);
  } else if (typeof variable === 'string') {
    variable.toUpperCase();
  }
}

abcd(12);


