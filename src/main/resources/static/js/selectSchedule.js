function choiceSchedule(h2) {
    const schedule = h2.textContent;
    console.log(schedule)
    document.querySelector("#time").value = `2022-09-15T${schedule}`;

 
}