public class Deadline extends Task {
        protected String by;
        protected char extraIcon;
        public Deadline(String description, String by) {
            super(description);
            this.by = by;
            this.extraIcon = 'D';
        
        }

        public char getExtraIcon(){
            return extraIcon;
        }
        public String getBy() {
            return by;
        }

         

        @Override
        public String toString(){
            return"[" + getExtraIcon() + "][" + super.getStatusIcon() + "] " + super.description + "(by: " + by + ")";
        }

    }