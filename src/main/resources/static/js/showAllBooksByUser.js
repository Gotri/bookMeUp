$.get('/books/by/user/current', function (books) {
    let html = '';
    let header = '<thead>' +
        '<tr>' +
        '<th>Cover</th>' +
        '<th>Title</th>' +
        '<th>Author</th>' +
        '<th>You´re Rating</th>' +
        '</tr>' +
        '</thead>' +
        '<tbody>';

    html += header;

    for (let i = 0; i < books.length; i++) {
        let tr = '<tr>';
        tr += '<td><img src="' + books[i].coverReference + '" alt="coverImage" style="width: 50%; height: 50%"></td>';
        tr += '<td>' + books[i].title + '</td>';
        tr += '<td>' + books[i].author + '</td>';
        tr += '<td>' + getRatingAsStars(books[i].rating) + '</td>';
        tr += '</tr>';
        html += tr;
    }
    html += '</tbody>';

    $('#myBooks-table').html(html);
});

function getRatingAsStars(rating) {
    let ratingHTML = '';
    for (let i = 0; i < rating; i++) {
        ratingHTML += '<img src="/img/star_full.png" alt="star_full" style="height: 32px; width: 32px">';
    }
    return ratingHTML;
}