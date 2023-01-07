
function choiceSchedule(schedule) {
    if (window.confirm("Confirmar agendamento")) {
    const sch =schedule;
    const day = document.querySelector("#calendar").value;
    document.querySelector("#time").value = `${day}T${sch}`;
    console.log(`${day}T${sch}`)
    }
    else {
     const sch = "00:00";
        const day = "2020-01-01"
        document.querySelector("#time").value = `${day}T${sch}`;
        console.log(`${day}T${sch}`)
    }


}

