$.get('/users/current', function (user) {
    $('#user-name').text(user.username);
    if (user.username !== null) {
        $('#login-link').hide();
        $('#registration-link').hide();
    }
});