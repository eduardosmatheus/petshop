function _timeMask(num){
  return num < 10 ? "0" : "";
}

export function parseMillisecodsToTimeStringFormat(milliseconds) {
  var seconds = milliseconds / 1000;
  var hours = parseInt( seconds / 3600 );
  seconds = seconds % 3600;
  var minutes = parseInt( seconds / 60 );
  seconds = seconds % 60;
  var formatted = "%hours:%minutes:%seconds".replace('%hours', _timeMask(hours) + hours).replace('%minutes', _timeMask(minutes) + minutes).replace('%seconds',_timeMask(seconds) + seconds);
  return formatted;
}

export function parseTimeStringFormatToMillisecods(timeFormatted) {
  return Date.parse(new Date('1970-01-01T' + timeFormatted + 'Z'));
}
