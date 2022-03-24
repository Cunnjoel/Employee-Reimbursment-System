let user;

window.onload = async function () {

    let response = await fetch(`${domain}/session`);

    let responseBody = await response.json();

    if (!responseBody.success) {
        window.location = "../";
    }


    user = responseBody.data;


    getAllReimbursement();
   

    console.log(user)
    async function getAllReimbursement() {
        let response = await fetch(`${domain}/reimbursement?userId=${user.id}`);

        let responseBody = await response.json();

        let views = responseBody.data
        console.log(views)
        views.forEach(view => {
            createReimbersment(view)
        });
    }

    function createReimbersment(view) {
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
        <th class="submitteddate">${view.submitted}</th>
        <th class="resolveddate"></th>
        <th class="status"></th>`

        employeeTableElm.appendChild(reimbersementTableElm);

        if(`${view.statusId} === 2){
            return "Approved"
         }else 
         if(${view.statusId} === 3`){
             return "Denied"
         }else return "Pending"

        
    }
}