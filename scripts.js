$(document).ready(function () {
    // Inicializar variables desde localStorage
    let balanceGeneral = parseFloat(localStorage.getItem("balanceGeneral")) || 0;
    let depositoGeneral = parseFloat(localStorage.getItem("depositoGeneral")) || 0;
    let retiroGeneral = parseFloat(localStorage.getItem("retiroGeneral")) || 0;

    // Transacciones desde localStorage
    let transactions = JSON.parse(localStorage.getItem("transactions")) || [];
    let totalAmount = transactions.reduce((total, transaction) => total + transaction.amount, 0);

    function addTransactionRow(transaction) {
        let newRow = '<tr>' +
            '<td>' + transaction.date + '</td>' +
            '<td>' + transaction.type + '</td>' +
            '<td>' + transaction.description + '</td>' +
            '<td>' + transaction.amount.toFixed(2) + '</td>' +
            '<td>' + transaction.category + '</td>' +
            '<td>' + transaction.status + '</td>' +
            '</tr>';

        $('#transaction-table tbody').append(newRow);

        // Actualizar el total
        totalAmount += transaction.amount;
        $('#total-amount').text('Total: ' + totalAmount.toFixed(2));
    }

    function updateLocalStorage() {
        // Guardar variables en localStorage
        localStorage.setItem("balanceGeneral", balanceGeneral);
        localStorage.setItem("depositoGeneral", depositoGeneral);
        localStorage.setItem("retiroGeneral", retiroGeneral);
        localStorage.setItem("transactions", JSON.stringify(transactions));
    }

        // Restaurar transacciones en la tabla
        transactions.forEach(transaction => {
            addTransactionRow(transaction);
        });

    // Función para depósito
    $('#deposit-form').submit(function (event) {
        event.preventDefault(); 

        let depositAmount = parseFloat($('#deposit-amount').val());
        if (!isNaN(depositAmount) && depositAmount > 0) {
            let depositTransaction = {
                date: getCurrentDate(),
                type: 'Depósito',
                description: 'Depósito realizado',
                amount: depositAmount,
                category: 'Ingreso',
                status: 'Completado'
            };
            transactions.push(depositTransaction); 
            addTransactionRow(depositTransaction); 
            balanceGeneral += depositAmount; 
            depositoGeneral += depositAmount;
            updateBalanceDisplay(); 
            updateLocalStorage(); 
            $('#deposit-amount').val(''); 
            alert('Depósito completado');
        } else {
            alert('Monto ingresado es inválido');
        }
    });

    // Función para retiro
    $('#withdraw-form').submit(function (event) {
        event.preventDefault(); 

        let withdrawAmount = parseFloat($('#withdraw-amount').val());
        if (!isNaN(withdrawAmount) && withdrawAmount > 0 && withdrawAmount <= balanceGeneral) {
            let withdrawTransaction = {
                date: getCurrentDate(),
                type: 'Retiro',
                description: 'Retiro realizado',
                amount: withdrawAmount,
                category: 'Gasto',
                status: 'Completado'
            };
            transactions.push(withdrawTransaction); 
            addTransactionRow(withdrawTransaction); 
            balanceGeneral -= withdrawAmount; 
            retiroGeneral += withdrawAmount;
            updateBalanceDisplay(); 
            updateLocalStorage(); 
            $('#withdraw-amount').val(''); 
            alert('Retiro completado');
        } else {
            alert('Monto ingresado es inválido o mayor al saldo disponible');
        }
    });

    // Función para obtener la fecha actual (YYYY-MM-DD)
    function getCurrentDate() {
        let now = new Date();
        let year = now.getFullYear();
        let month = ('0' + (now.getMonth() + 1)).slice(-2);
        let day = ('0' + now.getDate()).slice(-2);
        return year + '-' + month + '-' + day;
    }

    // Función que actualiza la visualización del balance general
    function updateBalanceDisplay() {
        $('.card1 p').text("Monto disponible: $" + balanceGeneral.toFixed(2));
        $('.amount-value').text(balanceGeneral.toFixed(2));
        $('.amount-value-d').text(depositoGeneral.toFixed(2));
        $('.amount-value-r').text("-" + retiroGeneral.toFixed(2));
    }

    // Llamado de la función después de cargar la página
    updateBalanceDisplay();
});

