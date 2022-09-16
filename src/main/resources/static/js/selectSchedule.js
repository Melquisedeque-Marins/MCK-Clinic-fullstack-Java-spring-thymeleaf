

function choiceSchedule(schedule) {
    const sch =schedule;
    const day = document.querySelector("#calendar").value;
    console.log(day)
    document.querySelector("#time").value = `${day} ${sch}`;
}

function actualDate() {
    const date = new Date();
    console.log(date)
    document.querySelector("#calendar").value = "2022-09-16"
     
}
   