function removeStorage(id) 
{
    var find = document.getElementById('find').value;
    var str = localStorage.getItem(find);
    var data = JSON.parse(str);
    var result = "姓名:" + data.name + '<br>';
    result += "Email:" + data.email + '<br>';
    result += "電話號碼:" + data.tel + '<br>';
    result += "備註:" + data.memo + '<br>';
    var target = document.getElementById(id);
    target.innerHTML = result;
    localStorage.removeItem(find);
}

function reNewStorage() 
{
    var data = new Object;
    data.name = document.getElementById('nameNew').value;
    data.email = document.getElementById('emailNew').value;
    data.tel = document.getElementById('telNew').value;
    data.memo = document.getElementById('memoNew').value;
    var str = JSON.stringify(data);
    localStorage.setItem(data.name,str);
    alert("資料已更新");
    window.location.href="welcome.html";
}

function logout() 
{
    alert("歡迎再次登入");
    window.location.href="index.html";
}