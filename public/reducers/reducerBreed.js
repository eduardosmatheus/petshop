import { FETCH_BREEDS } from '../actions'

const INITIAL_STATE = { all : [], actual : null}

export default function(state = INITIAL_STATE, action) { 
  switch (action.type) {
    case FETCH_BREEDS:
      return {...state, all : action.payload.data }
      break
  }

  return state;
}
