
function choiceSchedule(schedule) {
    const sch =schedule;
    const day = document.querySelector("#calendar").value;
    document.querySelector("#time").value = `${day}T${sch}`;

}

