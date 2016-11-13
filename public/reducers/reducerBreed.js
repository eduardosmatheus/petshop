import { FETCH_BREEDS, ERROR, POST_USER } from '../actions'

const INITIAL_STATE = { all : [], actual : null, error : null}

export default function(state = INITIAL_STATE, action) {
  switch (action.type) {
    case FETCH_BREEDS:
      return {...state, all : action.payload }
      break
    case POST_USER:
      let {all} = state;
      all.push(action.payload);
      return {...state, all : all}
      break
    case ERROR :
      return {...state, error : action.error}
      break
  }

  return state;
}
