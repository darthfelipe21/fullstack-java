const form = document.getElementById('logueo');

function validarCuenta(evento) {
    evento.preventDefault(); 

    const usuario = document.getElementById('usuario').value;
    const contrasena = document.getElementById('contrasena').value;

    fetch('user_pass.json')
        .then(response => response.json())
        .then(data => {
            const usuarios = data.usuarios;
            const usuarioEncontrado = usuarios.find(user => user.usuario === usuario && user.contraseña === contrasena);

            if (usuarioEncontrado) {
                sessionStorage.setItem('auth', true);
                location.href = "./menu.html";                
            } else {
                alert("Usuario o contraseña incorrecta");
            }
        })
        .catch(error => {
            console.error('Error al cargar el archivo JSON:', error);
        });
}

form.addEventListener("submit", validarCuenta);

// Cargar el contenido del archivo user_pass.json
fetch('user_pass.json')
    .then(response => response.json())
    .then(data => {
        const usuario = data.usuarios[0].usuario;
        document.getElementById('username').textContent = usuario;
    })
    .catch(error => {
        console.error('Error al cargar el archivo user_pass.json:', error);
    });

