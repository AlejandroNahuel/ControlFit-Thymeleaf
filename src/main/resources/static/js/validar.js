const forms = document.querySelectorAll('.needs-validation');

function validacion() {
    // Obtener todos los formularios a los que queremos aplicar estilos de validación de Bootstrap personalizados
    


    // Bucle sobre ellos y evitar el envío
    Array.prototype.slice.call(forms)
        .forEach(function (form) {
            form.addEventListener('submit', function (event) {
                if (!form.checkValidity()) {
                    event.preventDefault();
                }

                form.classList.add('was-validated');
                //document.getElementById('name').classList.add('bg-danger')

            }, false);
        });
}

validacion();























// //Establecer expresiones regulares
// const expresiones = {
// 	name: /^[a-zA-ZÀ-ÿ\s]{1,40}$/, // Letras y espacios, pueden llevar acentos.
// 	lastName: /^[a-zA-ZÀ-ÿ\s]{1,40}$/, // Letras y espacios, pueden llevar acentos.
// 	gymName: /^[a-zA-Z0-9\_\-]{4,16}$/, // Letras, numeros, guion y guion_bajo
// 	correo: /^[a-zA-Z0-9_.+-]+@[a-zA-Z0-9-]+\.[a-zA-Z0-9-.]+$/,
// 	telefono: /^\d{7,14}$/ // 7 a 14 numeros.
// }

// const campos = {
// 	usuario: false,
// 	nombre: false,
// 	password: false,
// 	correo: false,
// 	telefono: false
// }

// //Funcion validacion
// const validarFormulario = (e) => {
//     //En el caso del input seleccionado ejecutar...
//     switch (e.target.name) {
//         case "name":
//             console.log('work name');
//             if(expresiones.name.test(e.target.value)) {
//                 document.getElementById('name').classList.add('was-validated')
//             } else {
                
//             }

//         break;
//         case "lastName":
//             console.log('work lastName');
//             if(expresiones.name.test(e.target.value)) {
                
//             } else {
                
//             }
//         break;
//         case "gymName":
//             console.log('work gymName');
//             if(expresiones.lastName.test(e.target.value)) {
                
//             } else {
                
//             }
//         break;
//         case "email":
//             console.log('work email');
//             if(expresiones.email.test(e.target.value)) {
                
//             } else {
                
//             }
//         break;
//         case "phone":
//             console.log('work phone');
//             if(expresiones.phone.test(e.target.value)) {
                
//             } else {
                
//             }
//         break;
//     }

// }

// //funcion que ejecuta la validacion para cada input y fuera de los input
// inputs.forEach((input) => {
//     //Evento tecla en input
//     input.addEventListener('keyup', validarFormulario);

//     //Evento fuera de input
//     input.addEventListener('blur', validarFormulario);
// });

// //añadimos evento al form
// formulario.addEventListener('submit', (e) => {
//     e.preventDefault();
// });

