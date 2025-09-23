"use strict";
/*let variable: string | number;
variable = "12";

if (typeof variable === 'string') {;
  variable.toUpperCase();
} else if (typeof variable === 'number') {;
  variable.toFixed(2);
};*/
Object.defineProperty(exports, "__esModule", { value: true });
function abcd(variable) {
    if (typeof variable === 'number') {
        variable.toFixed(2);
    }
    else if (typeof variable === 'string') {
        variable.toUpperCase();
    }
}
abcd(12);
//# sourceMappingURL=typeInterface.js.map