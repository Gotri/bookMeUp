$.get('/users/all', function (users) {
    let html = '';
    let header = '<thead><tr><th>Username</th><th>Email</th></tr></thead><tbody>';
    html += header;

    for (let i = 0; i < users.length; i++) {
        let tr = '<tr>';
        tr += '<td>' + users[i].username + '</td>';
        tr += '<td>' + users[i].email + '</td>';
        tr += '</tr>';
        html += tr;
    }
    html += '</tbody>';

    $('#user-table').html(html);
});