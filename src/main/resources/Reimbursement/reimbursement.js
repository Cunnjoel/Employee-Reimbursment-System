let user;

window.onload = async function () {

    //this is used to retrieve query param
    let response = await fetch(`${domain}/session`);

    let responseBody = await response.json();

    if (!responseBody.success) {
        window.location = "../";
    }


    user = responseBody.data;
console.log(user.id)
    document.getElementById("reimb-form").addEventListener("submit", async function (event) {
        event.preventDefault();

        let amountInputElem = document.getElementById("amount");
        let descriptionInputElem = document.getElementById("description");
        let typeInputElem = document.querySelector('input[name=type]:checked').value;
        console.log(amountInputElem)
        let reimbersement = {
            amount: amountInputElem.value,
            userId: user.id,
            description: descriptionInputElem.value,
            statusId: 1,
            typeId: typeInputElem
        }

        console.log(reimbersement)
        let response = await fetch("http://localhost:9000/reimbursement", {
            method: "POST",
            body: JSON.stringify(reimbersement)

        })

        let responseBody = await response.json();

        if (responseBody.success == false) {
            let messageElem = document.getElementById("message")
            messageElem.innerText = responseBody.message
        }else{
            document.getElementById("reimb-form") = "";
        }
    })
}