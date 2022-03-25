let user;

window.onload = async function () {

    let response = await fetch(`${domain}/session`);

    let responseBody = await response.json();

    if (!responseBody.success) {
        window.location = "../";
    }


    user = responseBody.data;


    getAllReimbursement();

    async function getAllReimbursement() {
        let response = await fetch(`${domain}/viewall`);

        let responseBody = await response.json();

        let views = responseBody.data

        views.forEach(view => {
            createReimbersment(view)
            approved(view)
            denied(view)
        });
    }

    function createReimbersment(view) {
        let managerTableElm = document.getElementById("manager-table");

        let reimbersementTableElm = document.createElement("tr")

        console.log(view)
        reimbersementTableElm.innerHTML = `
        <td class="firstname">${view.firstname}</td>
        <td class="lastname">${view.lastname}</td>
        <td class="amount">${view.amount}</td>
        <td class="description">${view.description}</td>
        <td class="receipt"></td>
        <td class="type">${view.typeId}</td>
        <td class="authorized">${view.userId}</td>
        <td class="submitteddate">${view.submitted}</td>
        <td class="resolveddate"></td>
        <td class="status">${view.status}</td>
        <div><button class="btn btn-success" onclick="approved()" value="Approved">Approved</button></div>
        <div><button class="btn btn-danger" onclick="denied()" value="Denied">Denied</button></div>`

        managerTableElm.appendChild(reimbersementTableElm);

    }

}


async function approved(view){
    console.log(view.id)
    await fetch(`${domain}/approved/${view.id}`, {
        method: "PATCH"
    });
}

async function denied(view){
    await fetch(`${domain}/denied/${view.id}`, {
        method: "PATCH"
    });
}

function sortStatus(n) {
    let table, rows, switching, i, x, y, shouldSwitch, dir, switchcount = 0;
    table = document.getElementById("manager-table");
    switching = true;

    dir = "asc";

    while (switching) {
        switching = false;
        rows = table.rows;

        for (i = 1; i < (rows.length - 1); i++) {
            shouldSwitch = false;

            x = rows[i].getElementsByTagName("td")[n];
            y = rows[i + 1].getElementsByTagName("td")[n];

            if (dir == "asc") {
                if (x.innerHTML.toLowerCase() > y.innerHTML.toLowerCase()) {
                    shouldSwitch = true;
                    break;
                }
            } else
                if (dir == "desc") {
                    if (x.innerHTML.toLowerCase() < y.innerHTML.toLowerCase()) {
                        shouldSwitch = true;
                        break;
                    }
                }
        }
        if (shouldSwitch) {
            rows[i].parentNode.insertBefore(rows[i + 1], rows[i]);
            switching = true;
            switchcount++;
        } else {
            if (switchcount == 0 && dir == "asc") {
                dir = "desc";
                switching = true;
            }
        }
    }
}