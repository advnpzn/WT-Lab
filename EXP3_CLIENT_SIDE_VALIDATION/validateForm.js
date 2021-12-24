function validateForm() {
    var name = document.getElementById("name");
    var nameData = name.value;

    if (nameData == "" || nameData == null) {
        alert("Name must be filled!");
        return false;
    }
    else {
        return true;
    }
}
