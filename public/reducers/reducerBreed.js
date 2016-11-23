import { CLEAR_ACTUAL_BREED, FETCH_BREEDS, CREATE_BREED, GET_BRRED, UPDATE_BREED, DELETE_BREED, ERROR } from '../actions'

const INITIAL_STATE = {
  all : [],
  actual : {
    id : '',
    name : ''
  },
  error : null
}

export default function(state = INITIAL_STATE, action) {
  let {all, actual} = state
  switch (action.type) {
    case FETCH_BREEDS:
      return {...state, all : action.payload }
      break
    case CREATE_BREED:
      all.push(action.payload)
      return {...state, all : state.all}
      break
    case UPDATE_BREED:
      let i = all.indexOf(state.actual)
      all.splice(i, 1, action.payload)
      return {...state, all : state.all, actual : INITIAL_STATE.actual}
      break
    case DELETE_BREED:
      let x = all.indexOf(state.actual)
      all.splice(i, 1)
      return {...state, all : state.all, actual : INITIAL_STATE.actual}
      break
    case GET_BRRED:
      return {...state, actual : action.payload }
      break
    case CLEAR_ACTUAL_BREED:
      return {...state, actual : INITIAL_STATE.actual}
      break
    case ERROR :
      return {...state, error : action.error}
      break
  }

  return state;
}
