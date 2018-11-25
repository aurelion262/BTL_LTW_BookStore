/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
var jsImageURL1;
var jsImageURL;
var regexAlert='';

function testRegex(type,elementId)
{
    var value = document.getElementById(elementId).value;
    var regex;
    if(type==='email')
    {
        regex = /[A-Z0-9._%+-]+@[A-Z0-9-]+.+.[A-Z]{2,4}/igm;
        if(!regex.test(value)) regexAlert+="Email không đúng định dạng\n";
        return regex.test(value);
    }
    if(type==='phoneNumber')
    {
        if(!(value.length===10&&value.substring(0,1)==='0')) regexAlert+="Chỉ chấp nhận số điện thoại di động của Việt Nam\n";
        return(value.length===10&&value.substring(0,1)==='0');
    }
    if(type==='username')
    {
        regex = /^[\w]{6,18}$/;
        if(!regex.test(value)) regexAlert+="Tên tài khoản phải dài từ 6-18 kí tự, chỉ bao gồm chữ, số và dấu _\n";
        return regex.test(value);
    }
    if(type==='password')
    {
        if(document.getElementById('iptPassword').value!==document.getElementById('iptRepassword')) regexAlert+="Mật khẩu không trùng khớp\n";
        regex = /^.{6,30}$/;
        if(!regex.test(value)) regexAlert+="Mật khẩu phải dài từ 6-30 kí tự\n";
        return regex.test(value);
    }
}

function registerInputCheck()
{   
    testRegex('username','iptUsername');
    testRegex('password','iptPassword');
    testRegex('email','iptEmail');
    testRegex('phoneNumber','iptPhoneNumber');    
    
    if(regexAlert!=='')
    {
        alert(regexAlert);
        regexAlert='';
        return false;
    }
    else return true;
}

function jsSearchOption(option)
{
    if(option==='name')
    {
            jsRemoveAttribute('iptBookName',"hidden");
            jsSetAttribute('iptAuthor',"hidden","true");
            jsSetAttribute('iptCeilingPrice',"hidden","true");
            jsSetAttribute('iptFloorPrice',"hidden","true");
            jsSetAttribute('iptCategory',"hidden","true");
    }
    if(option==='author')
    {
            jsRemoveAttribute('iptAuthor',"hidden");
            jsSetAttribute('iptBookName',"hidden");
            jsSetAttribute('iptCeilingPrice',"hidden","true");
            jsSetAttribute('iptFloorPrice',"hidden","true");
            jsSetAttribute('iptCategory',"hidden","true");
    }
    if(option==='category')
    {
            jsSetAttribute('iptBookName',"hidden","true");
            jsSetAttribute('iptAuthor',"hidden","true");
            jsSetAttribute('iptCeilingPrice',"hidden","true");
            jsSetAttribute('iptFloorPrice',"hidden","true");
            jsRemoveAttribute('iptCategory',"hidden");
    }
    if(option==='finalPrice')
    {
            jsRemoveAttribute('iptCeilingPrice',"hidden");
            jsSetAttribute('iptAuthor',"hidden","true");
            jsRemoveAttribute('iptFloorPrice',"hidden");
            jsSetAttribute('iptBookName',"hidden","true");
            jsSetAttribute('iptCategory',"hidden","true");
    }
}

function jsSetAttribute(id,attribute,value)
{
    document.getElementById(id).setAttribute(attribute,value);
}

function jsRemoveAttribute(id,attribute)
{
    document.getElementById(id).removeAttribute(attribute);
}

function jsAppendAttribute(id,attribute,value)
{
    var finalvalue = document.getElementById(id).getAttribute(attribute) + value;
    document.getElementById(id).setAttribute(attribute,finalvalue);
}

function jsUpdateImage(event,id)
{
    jsRemoveAttribute(id,"hidden");
    jsImageURL1 = window.URL.createObjectURL(event.target.files[0]);
    jsImageURL = document.getElementById('iptImage').files[0].name;
    document.getElementById(id).setAttribute("src",jsImageURL1);
}

function aloalo()
{
    alert('aloalo');
}