// Save Toggle state of the side navigation
$("#sidenavToggler").click(function(e) {
    if ($("body").hasClass("sidenav-toggled")) {
        localStorage.setItem('sideNavToggled', 'toggled')
    } else {
        localStorage.removeItem('sideNavToggled')
    }
});

// restore toggle state
$(document).ready(function(e) {
    if (localStorage.getItem('sideNavToggled') === 'toggled') {
        $("#sidenavToggler").click();
    }
});

$(document).ready(function() {
    $('[data-toggle="tooltip"]').tooltip();
});