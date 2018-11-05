/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
var jsImageURL1;
var jsImageURL;
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