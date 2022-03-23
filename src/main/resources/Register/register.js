document.getElementById("register-form").addEventListener("submit", async function(event){
    event.preventDefault();

    let usernameInputElem = document.getElementById("username");
    let passwordInputElem = document.getElementById("password");
    let firstnameInputElem = document.getElementById("firstname");
    let lastnameInputElem = document.getElementById("lastname");
    let emailInputElem = document.getElementById("email");
    let roleInputElem = document.querySelector('input[name=role]:checked').value;
    console.log(roleInputElem)
    let user = {
        username: usernameInputElem.value,
        password: passwordInputElem.value,
        firstname: firstnameInputElem.value,
        lastname: lastnameInputElem.value,
        email: emailInputElem.value,
        roleId: roleInputElem
    }
    console.log(user)
    let response = await fetch("http://localhost:9000/register", {
        method: "POST",
        body: JSON.stringify(user)
        
    })

    let responseBody = await response.json();

    if(responseBody.success == false){
        let messageElem = document.getElementById("message")
        messageElem.innerText = responseBody.message
    }else{
        window.location = `../`
    }
})