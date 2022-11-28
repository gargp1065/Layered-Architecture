function login() {
    let username = document.getElementById("username1").value;
    let password = document.getElementById("password1").value;
    let role = document.getElementById("loginType").value;
    alert(role);
    let data = {
        username: username,
        password: password,
    };
    console.log(data);
    alert(data);
    if(role === "examAdmin") {
        fetch("http://localhost:8080/layered_oaes_war_exploded/api/login/admin", {
            // Adding method type
            method: "POST",
            body: JSON.stringify(data),
            // Adding headers to the request
            headers: {
                "Content-type": "application/json; charset=UTF-8",
            },
        }).then((response) => {
            location.href = 'addAuthor.html';
            alert(response.status);
            alert("LOGIN SUCCESSFULL");
        }).catch((error) => {
            alert("hee also")
            alert(error);
            console.log(error);
        })
    }
    else {
        fetch("http://localhost:8080/layered_oaes_war_exploded/api/login/author", {
            // Adding method type
            method: "POST",
            body: JSON.stringify(data),
            // Adding headers to the request
            headers: {
                "Content-type": "application/json; charset=UTF-8",
            },
        }).then((response) => {
            location.href = 'authorDashboard.html';
            alert("LOGIN SUCCESSFULL");

            console.log(response);
        }).catch((error) => {
            console.log(error);
        })
    }
}
function authorDashboard(){
    let operation = document.getElementById("authorOperation").value;
    alert(operation)
    if(operation == "addItem"){
        location.href = 'addItemPage.html';
    }
    else{
        location.href = 'generateNewQuesPaper.html';
    }
}
function addAuthor(){
    let username = document.getElementById("username1").value;
    let password = document.getElementById("password1").value;
    let data = {
        username: username,
        password: password,
    };
    console.log(data);
    alert(data);
        fetch("http://localhost:8080/layered_oaes_war_exploded/api/author/add", {
            // Adding method type
            method: "POST",
            body: JSON.stringify(data),
            // Adding headers to the request
            headers: {
                "Content-type": "application/json; charset=UTF-8",
            },
        }).then((response) => {
            location.href = 'addAuthor.html';
            alert("Added Successfully");
        }).catch((error) => {
            alert("hee also")
            alert(error);
            console.log(error);
        })
}

function addItem(){
    let question = document.getElementById("questionDescription").value;
    let subject = document.getElementById("subject").value;
    let authorId = document.getElementById("authorid").value;
    let option1 = document.getElementById("option1").value;
    let option2 = document.getElementById("option2").value;
    let option3 = document.getElementById("option3").value;
    let option4 = document.getElementById("option4").value;
    let correct = document.getElementById("correct").value;
    let data = {
        question: question,
        correctAnswer: correct,
        subject: subject,
        authorId: authorId,
        optionA: option1,
        optionB: option2,
        optionC: option3,
        optionD: option4,
    };
    console.log(data);
    alert(question);
    fetch("http://localhost:8080/layered_oaes_war_exploded/api/mcq/addMCQ", {
        // Adding method type
        method: "POST",
        body: JSON.stringify(data),
        // Adding headers to the request
        headers: {
            "Content-type": "application/json; charset=UTF-8",
        },
    }).then((response) => {
        alert(response.status);
        location.href = 'authorDashboard.html';
        alert("Added Successfully");
    }).catch((error) => {
        alert("hee also")
        alert(error);
        console.log(error);
    })
}



function viewQuestionPaper(){
    let myParent = document.getElementById("examdetails");
    let subject = document.getElementById("subject1").value;
    let count = document.getElementById("count1").value;
    let data = {
        subject: subject,
        count: count,
    };
    console.log(data);
    fetch("http://localhost:8080/layered_oaes_war_exploded/api/mcq/getMCQ", {
        // Adding method type
        method: "POST",
        body: JSON.stringify(data),
        // Adding headers to the request
        headers: {
            "Content-type": "application/json; charset=UTF-8",
        },
    })// Converting to JSON

        .then((response) => response.json())

        // Displaying results to console
        .then((json) => {
            console.log(json)
            let list = json;
            let array = [];
            for(let i=0;i<list.length;i++){
               alert(list[i].question  + "\n" + list[i].optionA + "\n" + list[i].optionB +"\n" + list[i].optionC+ "\n" + list[i].optionD);
            }
            // for (let i = 0; i < array.length; i++) {
            //     alert(array[i]);
            // }
        });
}