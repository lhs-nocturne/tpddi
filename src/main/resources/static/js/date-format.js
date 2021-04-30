function GetDateTimeToString() {
    var date_ = new Date();
    var year = date_.getFullYear();
    var month = date_.getMonth()+1;
    var day = date_.getDate();
    if(month<10) month = "0"+month;
    if(day<10) day = "0"+day;

    var hours = date_.getHours();
    var mins = date_.getMinutes();
    var secs = date_.getSeconds();
    var msecs = date_.getMilliseconds();
    if(hours<10) hours = "0"+hours;
    if(mins<10) mins = "0"+mins;
    if(secs<10) secs = "0"+secs;
    if(msecs<10) secs = "0"+msecs;
    return year+month+day+hours+mins+secs+msecs;
}