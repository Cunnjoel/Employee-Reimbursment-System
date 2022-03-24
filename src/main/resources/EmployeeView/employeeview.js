let user;

window.onload = async function () {

    let response = await fetch("http://localhost:9000/session");

    let responseBody = await response.json();

    if (!responseBody.success) {
        window.location = "../";
    }


    user = responseBody.data;


    getAllReimbursement();
}
console.log(user.id)
async function getAllReimbursement(){
    let response = await fetch(`http://localhost:9000/reimbursement?userId=${user.id}`);
    
    let responseBody = await response.json();

    let views = responseBody.data
console.log(view)
    views.forEach(view => {
        createReimbersment(view)
    });
}

function createReimbersment(view){
    let employeeTableElm = document.getElementById("employee-table");

    let reimbersementTableElm = document.createElement("tr")

    reimbersementTableElm.innerHTML = `
        <th class="firstname">${user.firstname}</th>
        <th class="lastname">${user.lastname}</th>
        <th class="amount">${view.amount}</th>
        <th class="description">${view.description}</th>
        <th class="receipt"></th>
        <th class="type">${view.typeId}</th>
        <th class="authorized">${view.userId}</th>
        <th class="submitteddate"></th>
        <th class="resolveddate"></th>
        <th class="status">${view.statusId}</th>`

    employeeTableElm.appendChild(reimbersementTableElm);
}