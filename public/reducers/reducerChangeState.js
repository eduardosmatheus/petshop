export default function(state = {}, action) {
  switch (action.type) {
    case 'CHANGE-STATE':
      return action.payload
      break
    default:
      return state
  }
}
