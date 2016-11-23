const INITIAL_STATE = {
  isActive : false,
  body : {
    modalTitle : "",
    contentRender : () => {}
  }
}

export default function(state = INITIAL_STATE, action) {

  if('OPEN_MODAL' === action.type) {
    state = { body : action.payload, isActive : true }
    return state
  }

  return INITIAL_STATE;
}
