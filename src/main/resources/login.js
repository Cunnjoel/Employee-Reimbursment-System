window.onload = async function(){
    let response = await fetch("http://localhost:9000/session");
    let responseBody = await response.json();

    if(responseBody.success){
        window.location = "./EmployeeView"
    }
}

document.getElementById("login-form").addEventListener("submit", async function(event){
    event.preventDefault();

    let usernameInputElem = document.getElementById("username");
    let passwordInputElem = document.getElementById("password");

    let user = {
        username: usernameInputElem.value,
        password: passwordInputElem.value
    }

    let response = await fetch("http://localhost:9000/session", {
        method: "POST",
        body: JSON.stringify(user)
    })

    let responseBody = await response.json();
    console.log(responseBody)
    if(responseBody.success == false){
        let messageElem = document.getElementById("message")
        messageElem.innerText = responseBody.message
    }else
    if(responseBody.data.roleId == 1){
       window.location = "./ManagerView"
    }else  window.location = `./EmployeeView?userId=${responseBody.data.id}`
})