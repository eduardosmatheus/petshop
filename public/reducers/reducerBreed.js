import { FETCH_BREEDS, CREATE_BREED, GET_BRRED, ERROR } from '../actions'

const INITIAL_STATE = {
  all : [],
  actual : {
    id : '',
    name : ''
  },
  error : null
}

export default function(state = INITIAL_STATE, action) {
  switch (action.type) {
    case FETCH_BREEDS:
      return {...state, all : action.payload }
      break
    case CREATE_BREED:
      let {all, actual} = state
      all.push(action.payload)
      return {...state, all : all}
      break
    case GET_BRRED:
      return {...state, actual : action.payload }
      break
    case ERROR :
      return {...state, error : action.error}
      break
  }

  return state;
}
