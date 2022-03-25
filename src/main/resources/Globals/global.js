let domain = "http://localhost:9000"

async function logout(){
    let response = await fetch("http://localhost:9000/session",{
        method:"DELETE"

    });
    let responseBody = await response.json();

    if(responseBody.success){
        window.location = "./"
    }
}
