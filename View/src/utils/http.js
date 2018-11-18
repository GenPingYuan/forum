const APIPREFIX = "/api"
const get = function (url) {
    url = APIPREFIX + url;
    return fetch(url, {
        credentials: 'include',
        headers: {
            'Accept': 'application/json, text/plain, */*',
            'Content-Type': 'application:json;charset=utf8'
        }
    }).then((res) => {
        return res.text();
    })
}

function obj2params(paramObj) {
    var param = "";
    for (const item in paramObj) {
        param += "&" + item + "=" + paramObj[item];
    }
    param = param.slice(1);
    return param;
}


const post = function (url, options) {

    url = APIPREFIX + url;
    console.log(url);
    return fetch(url, {
        method: "POST",
        credentials: "include",
        headers: {
            'Accept': 'application/json, text/plain, */*',
            'Content-Type': 'application:json;charset=utf8'
        },
        body: obj2params(options)
    }).then((res) => {
        return res.text();
    })
}

export { get, post }