const INITIAL_STATE = {
  isActive : false,
  body : {
    modalTitle : "",
    contentRender : () => {},
    onModalMount : () => {},
    onModalUnmount : () => {}
  }
}

export default function(state = INITIAL_STATE, action) {

  if('OPEN_MODAL' === action.type) {
    state = { body : action.payload, isActive : true }
    return state
  } else {
    if('CLOSE_MODAL' === action.type) {
      return INITIAL_STATE;
    }
  }

  return state;
}
