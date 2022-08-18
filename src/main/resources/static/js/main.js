// Take all HTML elements to calculate final price
let $rangeCupoSocios = document.getElementById('range');
let $cWhatsapp = document.getElementById('cWhatsapp');
let $cSocios = document.getElementById('cSocios');
let $cDuenios = document.getElementById('cDuenios');
let $cCompuExtra = document.getElementById('cCompuExtra');
let $precioFinal = document.getElementById('finalPrice');


//add an EventListener to everyone of the elements but $precioFinal
$rangeCupoSocios.addEventListener('mousemove', calcularPrecio);
$cWhatsapp.addEventListener('change', calcularPrecio);
$cSocios.addEventListener('change', calcularPrecio);
$cDuenios.addEventListener('change', calcularPrecio);
$cCompuExtra.addEventListener('change', calcularPrecio);

//probando con evento slide
$rangeCupoSocios.addEventListener('touchmove', calcularPrecio);

// Create a function to calculate final Price
function calcularPrecio(){
    let precioInicial = 2700;
    let precioAgregado=0;
    let precioFinal=0;

    document.getElementById('rangeLabel').innerHTML = document.getElementById('range').value;

    switch(parseInt($rangeCupoSocios.value)){
        case 100:
            precioAgregado = 0;
            break;
        case 200:
            precioAgregado = 400;
            break;
        case 300:
            precioAgregado = 800;
            break;
        case 400:
            precioAgregado = 1200;
            break;
        case 500:
            precioAgregado = 1600;
            break;
        case 600:
            precioAgregado = 2000;
            break;
        case 700:
            precioAgregado = 2400;
            break;
        case 800:
            precioAgregado = 2800;
            break;
        case 900:
            precioAgregado = 3200;
            break;
        case 1000:
            precioAgregado = 3600;
            break;
        
    }
    if($cWhatsapp.checked){
        precioAgregado+= 1500;
    }

    if($cSocios.checked){
        precioAgregado+= 1900;
    }

    if($cDuenios.checked){
        precioAgregado+= 1200;
    }

    if($cCompuExtra.checked){
        precioAgregado+= 700;
    }

    precioFinal = precioInicial + precioAgregado;

    $precioFinal.innerHTML = '$ ' + precioFinal + ',00';
}


/*Precio inicial       2700
cupo c/100per     400 
notiwpp             1500
appmovilSocios 1900
appmovilDueño 1200
compuExtra          700*/