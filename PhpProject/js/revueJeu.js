function incrementValue1()
{
    var value = parseInt(document.getElementById('number1').value, 10);
    value = isNaN(value) ? 0 : value;
    value++;
    document.getElementById('number1').value = value;
    onClick();
}

function decrementValue1()
{
    var value = parseInt(document.getElementById('number1').value, 10);
    value = isNaN(value) ? 0 : value;
    value--;
    document.getElementById('number1').value = value;
    onClick();
}

function incrementValue2()
{
    var value = parseInt(document.getElementById('number2').value, 10);
    value = isNaN(value) ? 0 : value;
    value++;
    document.getElementById('number2').value = value;
    onClick();
}

function decrementValue2()
{
    var value = parseInt(document.getElementById('number2').value, 10);
    value = isNaN(value) ? 0 : value;
    value--;
    document.getElementById('number2').value = value;
    onClick();
}

function onClick()
{
	document.getElementById('push_button_once').disabled = true;
}