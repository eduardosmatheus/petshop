export function changeState(param) {
  console.log(param);
  return {
    type : 'CHANGE-STATE',
    payload : param
  }
}
