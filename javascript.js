/*
var nombre = "Felipe"
const numero = 10

for (let x = 1; x < 10; x++){
    let numero = x;
    let nombre = "Rafael";

    console.log('El nombre dentro del bucle: ');
    console.log(numero+".- "+nombre); // muestra el valor de la variable nombre que está en
}

console.log("///////////////////////////////////////////////");

console.log("El nombre global: " + nombre + " " + numero);

console.log("///////////////////////////////////////////////");

let x = 10;
let y = 5;

let suma  = x + y;

console.log("La suma de X y Y = " + suma)

console.log("///////////////////////////////////////////////");

let edad;

//edad = parseInt(prompt("ingrese su edad: "))
// parseFloat

//alert('tu edad es de: ' + edad + " años")


//const usuario = prompt( "Nombre de usuario: ");
//const contraseña = prompt( "Ingrese una contraseña: ");

//alert("Su nombre de usuario es: " + usuario + " y su contraseña es : " + contraseña);

console.log("///////////////////////////////////////////////");

//let numero1 = parseInt(prompt( "Ingrese un número: " ));
//let numero2 = parseInt(prompt( "Ingrese otro número: "));

let sumar = numero1 + numero2;
let resta = numero1 - numero2;
let multi = numero1 * numero2;
let division = numero1 / numero2;

console.log("La suma de los números es: "+sumar);
console.log("La resta de los números es: "+resta);
console.log("La multiplicación de los números es: "+multi);
console.log("La división de los números es: "+division);
*/


//switch y condicionales

const day_number = parseInt(prompt("Ingrese un numero de la semana"));

switch (day_number) {
    case 1:
        console.log("Lunes");
        break;
    case 2:
        console.log("Martes");
        break;
    case 3:
        console.log("Miércoles");
        break;
    case 4:
        console.log("Jueves");
        break;
    case 5:
        console.log("Viernes");
        break;
    case 6:
        console.log("Sabado");
        break;
    case 7:
        console.log("Domingo");
        break;
    default:
        console.log("Día no válido");
}