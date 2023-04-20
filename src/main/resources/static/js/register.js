function validateRegister() {
        // debugger
        var firstNameElement = document.getElementById("firstName");
        var lastNameElement = document.getElementById("lastName");
        var emailElement = document.getElementById("email");
        var userNameElement = document.getElementById("userName");
        var passwordElement = document.getElementById("password");
        var confirmPasswordElement = document.getElementById("confirmPassword");

        var status = false;
        var message = "Please fill all mandatory fields";

        setBorderColor(firstNameElement);
        setBorderColor(lastNameElement);
        setBorderColor(emailElement);
        setBorderColor(userNameElement);
        setBorderColor(passwordElement);
        setBorderColor(comfirmPasswordElement);
        var email = emailElement.val();

        if (email != "" &&!validateEmail(email)) {
            message = "Email is incorrect format";
            emailElement.style.borderColor = "red";
        } else if (passwordElement.value != comfirmPasswordElement.value) {
            message = "Comfirm password is not match with password";
            comfirmPasswordElement.style.borderColor = "red";
        }

        var numberOfInput = document.getElementsByTagName("input").length;
        var countValidInput = 0;

        for (var j = 0; j < numberOfInput; j++) {
            if (document.getElementsByTagName("input")[j].style.borderColor == "green") {
                countValidInput++;
            }
        }

        if (countValidInput == numberOfInput) {
            message = "";
            status = true;
        }

}

function validateEmail(email) {
    var re = /(?:[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*|"(?:[\x01-\x08\x0b\x0c\x0e-\x1f\x21\x23-\x5b\x5d-\x7f]|\\[\x01-\x09\x0b\x0c\x0e-\x7f])*")@(?:(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?|\[(?:(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\.){3}(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?|[a-z0-9-]*[a-z0-9]:(?:[\x01-\x08\x0b\x0c\x0e-\x1f\x21-\x5a\x53-\x7f]|\\[\x01-\x09\x0b\x0c\x0e-\x7f])+)\])/;
    return re.test(email);
}
function setBorderColor(element) {
    if (element.value == "") {
        element.style.borderColor = "red";
    } else {
        element.style.borderColor = "green";
    }
}