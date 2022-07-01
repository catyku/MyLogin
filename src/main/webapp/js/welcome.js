function saveStorage() 
{
    var data = new Object;
    data.name = document.getElementById('name').value;
    data.email = document.getElementById('email').value;
    data.tel = document.getElementById('tel').value;
    data.memo = document.getElementById('memo').value;
    var str = JSON.stringify(data);
    localStorage.setItem(data.name,str);
    alert("資料已儲存");
    window.location.href="welcome.html";
}

function findStorage(id) 
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
}

function changeStorage() 
{
    window.location.href="change_data.html";
}

function clearStorage()
{
    localStorage.clear();
    alert("清空完畢");
    window.location.href="index.html";
}

function logout() 
{
    alert("歡迎再次登入");
    window.location.href="index.html";
}