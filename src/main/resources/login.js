document.getElementById("login-form").addEventListener("submit", async function(event){
    event.preventDefault();

    let usernameInputElem = document.getElementById("username");
    let passwordInputElem = document.getElementById("password");

    let user = {
        username: usernameInputElem.value,
        password: passwordInputElem.value
    }

    let response = await fetch("http://localhost:9000/login", {
        method: "POST",
        body: JSON.stringify(user)
    })

    let responseBody = await response.json();
    
    console.log(responseBody)
    if(responseBody.success == false){
        let messageElem = document.getElementById("message")
        messageElem.innerText = responseBody.message
    }else{
        window.location = `./EmployeeView?userId=${responseBody.data.id}`
    }
})