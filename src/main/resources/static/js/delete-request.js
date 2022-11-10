const xhr = new XMLHttpRequest();
const method = "DELETE"

function request_url_delete(url) {
    xhr.open(method, url, true);

    xhr.send();
}