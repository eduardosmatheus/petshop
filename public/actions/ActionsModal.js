export function openModal(modalState) {
  return dispatch => {
    dispatch({
      type : 'OPEN_MODAL',
      payload : modalState
    })
  }
}

export function closeModal() {
  return dispatch => {
    dispatch({
      type : 'CLOSE_MODAL'
    })
  }
}
