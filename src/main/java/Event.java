public  class Event extends Task {
        
        protected char extraIcon;
        protected String from,to;
      
        public Event(String description, String from,String to) {
            
            super(description);
            this.from = from;
            this.to = to;
            this.extraIcon = 'E';
        
        }

        public char getExtraIcon(){
            return extraIcon;
        }
        

         
        
        @Override
        public String toString(){
            
            return"[" + getExtraIcon() + "][" + super.getStatusIcon() + "] " + super.description + "( " + from  + " " +  to + ")";
        }

    }